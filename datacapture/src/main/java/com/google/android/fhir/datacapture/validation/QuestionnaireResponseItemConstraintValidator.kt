/*
 * Copyright 2022-2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.fhir.datacapture.validation

import android.content.Context
import org.hl7.fhir.r4.model.Questionnaire
import org.hl7.fhir.r4.model.QuestionnaireResponse

/**
 * Validates [QuestionnaireResponse.QuestionnaireResponseItemComponent] against a particular
 * constraint.
 */
internal interface QuestionnaireResponseItemConstraintValidator : ConstraintValidator {
  /**
   * Validates that [questionnaireResponseItem] satisfy a particular constraint of the
   * [questionnaireItem] according to the [structured data capture implementation guide]
   * (http://build.fhir.org/ig/HL7/sdc/behavior.html).
   *
   * This does not validate the consistency between the structure of the [questionnaireResponseItem]
   * and their descendants and that of the [questionnaireItem] and its descendants.
   *
   * [Learn more](https://www.hl7.org/fhir/questionnaireresponse.html#link).
   */
  suspend fun validate(
    questionnaireItem: Questionnaire.QuestionnaireItemComponent,
    questionnaireResponseItem: QuestionnaireResponse.QuestionnaireResponseItemComponent,
    context: Context,
  ): List<ConstraintValidator.Result>
}
